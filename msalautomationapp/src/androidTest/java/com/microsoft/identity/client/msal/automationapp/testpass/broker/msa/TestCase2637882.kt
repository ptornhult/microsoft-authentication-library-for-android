//  Copyright (c) Microsoft Corporation.
//  All rights reserved.
//
//  This code is licensed under the MIT License.
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy
//  of this software and associated documentation files(the "Software"), to deal
//  in the Software without restriction, including without limitation the rights
//  to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
//  copies of the Software, and to permit persons to whom the Software is
//  furnished to do so, subject to the following conditions :
//
//  The above copyright notice and this permission notice shall be included in
//  all copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//  THE SOFTWARE.
package com.microsoft.identity.client.msal.automationapp.testpass.broker.msa

import com.microsoft.identity.client.Prompt
import com.microsoft.identity.client.msal.automationapp.R
import com.microsoft.identity.client.msal.automationapp.sdk.MsalAuthTestParams
import com.microsoft.identity.client.msal.automationapp.sdk.MsalSdk
import com.microsoft.identity.client.ui.automation.TokenRequestTimeout
import com.microsoft.identity.client.ui.automation.annotations.LocalBrokerHostDebugUiTest
import com.microsoft.identity.client.ui.automation.annotations.RetryOnFailure
import com.microsoft.identity.client.ui.automation.annotations.SupportedBrokers
import com.microsoft.identity.client.ui.automation.broker.BrokerHost
import com.microsoft.identity.client.ui.automation.interaction.PromptHandlerParameters
import com.microsoft.identity.client.ui.automation.interaction.PromptParameter
import com.microsoft.identity.client.ui.automation.interaction.microsoftsts.AadPromptHandler
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

// [PRTv3] Brokered Auth for MSA account - Consumers Authority
// https://identitydivision.visualstudio.com/Engineering/_workitems/edit/2637882
@SupportedBrokers(brokers = [BrokerHost::class])
@LocalBrokerHostDebugUiTest
@RetryOnFailure
class TestCase2637882 : AbstractMsaBrokerTest() {
    @Test
    @Throws(Throwable::class)
    fun test_2637882() {
        val username = mLabAccount.username
        val password = mLabAccount.password
        val msalSdk = MsalSdk()
        val authTestParams = MsalAuthTestParams.builder()
            .activity(mActivity)
            .loginHint(username)
            .scopes(Arrays.asList(*mScopes))
            .promptParameter(Prompt.SELECT_ACCOUNT)
            .msalConfigResourceId(configFileResourceId)
            .build()
        val authResult = msalSdk.acquireTokenInteractive(authTestParams, {
            val promptHandlerParameters = PromptHandlerParameters.builder()
                .prompt(PromptParameter.SELECT_ACCOUNT)
                .loginHint(username)
                .sessionExpected(false)
                .consentPageExpected(false)
                .speedBumpExpected(false)
                .broker(mBroker)
                .expectingBrokerAccountChooserActivity(false)
                .build()
            AadPromptHandler(promptHandlerParameters)
                .handlePrompt(username, password)
        }, TokenRequestTimeout.MEDIUM)
        authResult.assertSuccess()

        // Silent call
        val account = msalSdk.getAccount(mActivity, configFileResourceId, username)
        val silentParams = MsalAuthTestParams.builder()
            .activity(mActivity)
            .loginHint(username)
            .authority(account.authority)
            .forceRefresh(true)
            .scopes(Arrays.asList(*mScopes))
            .msalConfigResourceId(configFileResourceId)
            .build()
        val silentResult = msalSdk.acquireTokenSilent(silentParams, TokenRequestTimeout.MEDIUM)
        silentResult.assertSuccess()
    }

    override fun getConfigFileResourceId(): Int {
        return R.raw.msal_config_msa_only
    }
}
