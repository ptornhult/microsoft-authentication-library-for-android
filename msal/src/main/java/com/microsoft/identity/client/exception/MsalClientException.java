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

package com.microsoft.identity.client.exception;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;

/**
 * This exception class represents general errors that are local to the library. Below is the table of proposed codes and a short description of each.
 * <p>
 * Set of error codes that could be returned from this exception:
 * <ul>
 * <li>multiple_matching_tokens_detected: There are multiple cache entries found and the sdk cannot identify the correct access
 * or refresh token from the cache. This usually indicates a bug in the sdk for storing tokens or the authority is
 * not provided in the silent request and multiple matching tokens found. </li>
 * <li>device_network_not_available: No active network is available on the device. </li>
 * <li>json_parse_failure: The sdk failed to parse the JSON format.</li>
 * <li>io_error: IOException happened, could be the device/network errors. </li>
 * <li>malformed_url: The url is malformed. Likely caused when constructing the auth request, authority, or redirect URI. </li>
 * <li>unsupported_encoding: The encoding is not supported by the device. </li>
 * <li>no_such_algorithm: The algorithm used to generate pkce challenge is not supported. </li>
 * <li>invalid_jwt: JWT returned by the server is not valid, empty or malformed. </li>
 * <li>state_mismatch: State from authorization response did not match the state in the authorization request.
 * For authorization requests, the sdk will verify the state returned from redirect and the one sent in the request. </li>
 * <li>unsupported_url: Unsupported url, cannot perform ADFS authority validation. </li>
 * <li>authority_validation_not_supported: The authority is not supported for authority validation. The sdk supports
 * b2c authorities, but doesn't support b2c authority validation. Only well-known host will be supported. </li>
 * <li>chrome_not_installed: Chrome is not installed on the device. The sdk uses chrome custom tab for
 * authorization requests if available, and will fall back to chrome browser. </li>
 * <li>user_mismatch: The user provided in the acquire token request doesn't match the user returned from server.</li>
 * </ul>
 * </p>
 */
public final class MsalClientException extends MsalException {

    /**
     * The parameter provided by the user is invalid.
     * */
    public static final String INVALID_PARAMETER = "invalid_parameter";

    /**
     * There are multiple cache entries found, the sdk cannot pick the correct access token
     * or refresh token from the cache. Likely it's a bug in the sdk when caching tokens or authority
     * is not proviced in the silent request and multiple tokens were found.
     */
    public static final String MULTIPLE_MATCHING_TOKENS_DETECTED = ClientException.MULTIPLE_MATCHING_TOKENS_DETECTED;

    /**
     * No active network is available on the device.
     */
    public static final String DEVICE_NETWORK_NOT_AVAILABLE = ClientException.DEVICE_NETWORK_NOT_AVAILABLE;

    /**
     * A scope is required when making a token request
     */
    public static final String SCOPE_EMPTY_OR_NULL = ClientException.SCOPE_EMPTY_OR_NULL;

    /**
     * The sdk failed to parse the Json format.
     */
    public static final String JSON_PARSE_FAILURE = ClientException.JSON_PARSE_FAILURE;

    /**
     * IOException happened, could be the device/network errors.
     */
    public static final String IO_ERROR = ClientException.IO_ERROR;

    /**
     * The url is malformed.  Likely caused when constructing the auth request, authority, or redirect URI.
     */
    public static final String MALFORMED_URL = ClientException.MALFORMED_URL;

    /**
     * The authority is unknown.  Occurs when the authority is not part of configuration or the authority host is not recognized by Microsoft.
     */
    public static final String UNKNOWN_AUTHORITY = ClientException.UNKNOWN_AUTHORITY;

    /**
     * The encoding is not supported by the device.
     */
    public static final String UNSUPPORTED_ENCODING = ClientException.UNSUPPORTED_ENCODING;

    /**
     * The algorithm used to generate pkce challenge is not supported.
     */
    public static final String NO_SUCH_ALGORITHM = ClientException.NO_SUCH_ALGORITHM;

    /**
     * JWT returned by the server is not valid, empty or malformed.
     */
    public static final String INVALID_JWT = ClientException.INVALID_JWT;

    /**
     * State from authorization response did not match the state in the authorization request.
     * For authorization requests, the sdk will verify the state returned from redirect and the one sent in the request.
     */
    public static final String STATE_MISMATCH = ClientException.STATE_MISMATCH;

    /**
     * Unsupported url, cannot perform adfs authority validation.
     */
    public static final String UNSUPPORTED_URL = ClientException.UNSUPPORTED_URL;

    /**
     * The authority is not supported for authority validation. The sdk supports b2c authority, but we don't support b2c authority validation yet.
     * Only well-known host will be supported.
     */
    public static final String AUTHORITY_VALIDATION_NOT_SUPPORTED = ClientException.AUTHORITY_VALIDATION_NOT_SUPPORTED;

    /**
     * Note: after MSAL 0.2.0 this error is no longer relevant.
     * chrome_not_installed: Chrome is not installed on the device. The sdk uses chrome custom tab for
     * authorization requests if available, and will fall back to chrome browser.
     */
    public static final String CHROME_NOT_INSTALLED = "chrome_not_installed";

    /**
     * The user provided in the acquire token request doesn't match the user returned from server.
     */
    public static final String USER_MISMATCH = ClientException.USER_MISMATCH;

    /**
     * Extra query parameters set by the client app is already sent by the sdk.
     */
    public static final String DUPLICATE_QUERY_PARAMETER = ClientException.DUPLICATE_QUERY_PARAMETER;

    /**
     * Failed to bind the service in broker app.
     */
    public static final String BROKER_BIND_FAILURE = ErrorStrings.BROKER_BIND_SERVICE_FAILED;

    /**
     * Extra query parameters set by the client app is already sent by the sdk.
     */
    public static final String UNKNOWN_ERROR = ClientException.UNKNOWN_ERROR;

    /**
     * Broker app is not installed.
     */
    public static final String BROKER_NOT_INSTALLED = "broker_not_installed";

    /**
     * Not eligible to use Broker.
     */
    public static final String NOT_ELIGIBLE_TO_USE_BROKER = "not_eligible_to_use_broker";

     /**
     * No account currently signed in to SingleAccountPublicClientApplication
     */
     public static final String NO_CURRENT_ACCOUNT = "no_current_account";
    public static final String NO_CURRENT_ACCOUNT_ERROR_MESSAGE = "There is no signed in account.";

    /**
     * The account that is being signed in does not match with the provided account.
     */
    public static final String CURRENT_ACCOUNT_MISMATCH = "current_account_mismatch";
    public static final String CURRENT_ACCOUNT_MISMATCH_ERROR_MESSAGE = "The signed in account does not match with the provided account.";

    /**
     * Duplicate command.  The same command is already be processed.
     */
    public static final String DUPLICATE_COMMAND = "duplicate_command";

    /**
     * Developer error. Application manifest is not properly configured to support MSAL.
     */
    public static final String APP_MANIFEST_VALIDATION_ERROR = "app_manifest_validation_error";

    /**
     * More than one app is listening for the custom URL scheme determined by the Redirect URI in
     * the AndroidManifest.
     */
    public static final String MULTIPLE_APPS_LISTENING_CUSTOM_URL_SCHEME = "multiple_apps_listening_url_scheme";

    /**
     * Developer error. The redirect URI in the configuration file doesn't match with the one generated with package name and signature hash.
     */
    public static final String REDIRECT_URI_VALIDATION_ERROR = "redirect_uri_validation_error";

    /**
     * Temporary non-exposed error code to indicate that ADFS authority validation fails. ADFS as authority is not supported
     * for preview.
     */
    static final String ADFS_AUTHORITY_VALIDATION_FAILED = "adfs_authority_validation_failed";

    /**
     * Configuration error. SingleAccount apps cannot be used with multiple B2C policies, as each policy creates a separate Account.
     */
    public static final String SAPCA_USE_WITH_MULTI_POLICY_B2C = "SingleAccountPublicClientApplication cannot be used with multiple B2C policies.";

    /**
     * Configuration error. Native auth apps configuration must contain a client ID.
     */
    public static final String NATIVE_AUTH_USE_WITHOUT_CLIENT_ID_ERROR_CODE = "native_auth_use_without_client_id";
    public static final String NATIVE_AUTH_USE_WITHOUT_CLIENT_ID_ERROR_MESSAGE = "NativeAuthPublicClientApplication cannot be used without a client ID";

    /**
     * Configuration error. Native auth apps configuration must contain a client ID.
     */
    public static final String NATIVE_AUTH_APPLICATION_CREATION_UNKNOWN_ERROR_MESSAGE = "Unexpected error while initializing PCA.";

    /**
     * Configuration error. Native auth apps configuration passed with invalid or empty redirect uri
     */
    public static final String NATIVE_AUTH_USE_WITH_BAD_REDIRECT_URI_ERROR_CODE = "native_auth_use_with_bad_redirect_uri";
    public static final String NATIVE_AUTH_USE_WITH_BAD_REDIRECT_URI_ERROR_MESSAGE = "NativeAuthPublicClientApplication was given an empty or invalid redirect uri";

    /**
     * Configuration error. Native auth apps configuration must contain a tenant
     */
    public static final String NATIVE_AUTH_USE_WITHOUT_TENANT_ERROR_CODE = "native_auth_use_without_tenant";
    public static final String NATIVE_AUTH_USE_WITHOUT_TENANT_ERROR_MESSAGE = "NativeAuthPublicClientApplication cannot be used without a tenant";

    /**
     * Configuration error. Native auth apps cannot be used with anything other than SINGLE account mode.
     */
    public static final String NATIVE_AUTH_INVALID_ACCOUNT_MODE_CONFIG_ERROR_CODE = "native_auth_invalid_account_mode_config";
    public static final String NATIVE_AUTH_INVALID_ACCOUNT_MODE_CONFIG_ERROR_MESSAGE = "NativeAuthPublicClientApplication Native auth apps cannot be used with anything other than SINGLE account mode";

    /**
     * Configuration error. Native auth app is trying to use broker.
     */
    public static final String NATIVE_AUTH_ATTEMPTING_TO_USE_BROKER_ERROR_CODE = "native_auth_attempting_to_use_broker";
    public static final String NATIVE_AUTH_ATTEMPTING_TO_USE_BROKER_ERROR_MESSAGE = "NativeAuthPublicClientApplication cannot use broker";

    /**
     * Configuration error. Native auth app is set up in shared device mode.
     */
    public static final String NATIVE_AUTH_SHARED_DEVICE_MODE_ERROR_CODE = "native_auth_shared_device_mode";
    public static final String NATIVE_AUTH_SHARED_DEVICE_MODE_ERROR_MESSAGE = "NativeAuthPublicClientApplication cannot be used in shared device mode";

    /**
     * Configuration error. Native auth apps can only be used with a valid CIAM Authority.
     */
    public static final String NATIVE_AUTH_INVALID_CIAM_AUTHORITY_ERROR_CODE = "native_auth_invalid_ciam_authority";
    public static final String NATIVE_AUTH_INVALID_CIAM_AUTHORITY_ERROR_MESSAGE = "NativeAuthPublicClientApplication can only be used with a valid CIAM Authority";

    /**
     * Configuration error. Native auth apps can't be passed with no authority.
     */
    public static final String NATIVE_AUTH_USE_WITH_NO_AUTHORITY_ERROR_CODE = "native_auth_use_with_no_authority";
    public static final String NATIVE_AUTH_USE_WITH_NO_AUTHORITY_ERROR_MESSAGE = "NativeAuthPublicClientApplication can't be used with no authority.";

    /**
     * Configuration error. Native auth apps can't be passed with multiple authorities.
     */
    public static final String NATIVE_AUTH_USE_WITH_MULTI_AUTHORITY_ERROR_CODE = "native_auth_use_with_multi_authority";
    public static final String NATIVE_AUTH_USE_WITH_MULTI_AUTHORITY_ERROR_MESSAGE = "NativeAuthPublicClientApplication can't be used with multiple authorities";

    /**
     * Configuration error. Native Auth app must be passed with challenge types
     */
    public static final String NATIVE_AUTH_EMPTY_CHALLENGE_TYPE_ERROR_CODE = "native_auth_empty_challenge_type";
    public static final String NATIVE_AUTH_EMPTY_CHALLENGE_TYPE_ERROR_MESSAGE = "NativeAuthPublicClientApplication can't be used without challenge types";

    /**
     * Configuration error. Native auth app passed with an invalid challenge type.
     */
    public static final String NATIVE_AUTH_INVALID_CHALLENGE_TYPE_ERROR_CODE = "native_auth_invalid_challenge_type";
    public static final String NATIVE_AUTH_INVALID_CHALLENGE_TYPE_ERROR_MESSAGE = "NativeAuthPublicClientApplication detected invalid challenge type.";

    public MsalClientException(final String errorCode) {
        super(errorCode);
    }

    public MsalClientException(final String errorCode, final String errorMessage) {
        super(errorCode, errorMessage);
    }

    public MsalClientException(final String errorCode, final String errorMessage, final Throwable throwable) {
        super(errorCode, errorMessage, throwable);
    }
}
