package com.syncfy.management.infrastructure.services;

import com.syncfy.management.domain.AuthDtoCreatorDomain;
import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.domain.AuthDtoPayloadDomain;

public interface IAuthService {
    AuthDtoDomain validateOAuth(AuthDtoPayloadDomain payloadDomain);
    AuthDtoDomain newOAuthRegister(AuthDtoCreatorDomain domain);
}
