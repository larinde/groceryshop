/*
 * Copyright (c) 2016 HSBC
 * London
 * All rights reserved.
 */
package at.sitsolutions.services.ebv.licenceholder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class LicenceHolderRestClient implements LicenceHolderClient {

    private static final String BEARER_PREFIX = "bearer ";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";
    private final RestTemplate restTemplate;
    private final String baseUrl;

    @Autowired
    public LicenceHolderRestClient(String baseUrl, RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public ContactPersonRto createContactPerson(final Integer userNumber, final ContactPersonViewInRto contactPersonViewInRto) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(AUTHORIZATION_HEADER, BEARER_PREFIX + userNumber.toString());
            httpHeaders.set(CONTENT_TYPE, ContactPersonViewInRto.MEDIA_TYPE);
            URI url = new URI(baseUrl + "/"+userNumber.toString()+"/contactpersons");
            HttpEntity<ContactPersonViewInRto> requestEntity = new HttpEntity<>(contactPersonViewInRto, httpHeaders);
            ResponseEntity<ContactPersonRto> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ContactPersonRto.class);
            return responseEntity.getBody();
        } catch (URISyntaxException e) {
            throw new InvalidEndpointException();
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public Collection<ContactPersonRto> readContactPersons(final Integer userNumber, final String customerId) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(AUTHORIZATION_HEADER, BEARER_PREFIX + userNumber.toString());
            URI url = new URI(baseUrl + "/"+userNumber.toString()+"/contactpersons");
            @SuppressWarnings("rawtypes")
            ResponseEntity<Collection> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(httpHeaders), Collection.class);
            return (Collection<ContactPersonRto>) responseEntity.getBody();
        } catch (URISyntaxException e) {
            throw new InvalidEndpointException();
        }
    }

    @Override
    public ContactPersonRto updateContactPerson(final Integer userNumber, String id, final ContactPersonRto contactPersonRto) {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(AUTHORIZATION_HEADER, BEARER_PREFIX + userNumber.toString());
            httpHeaders.set(CONTENT_TYPE, ContactPersonRto.MEDIA_TYPE);
            URI url = new URI(baseUrl + "/"+userNumber.toString()+"/contactpersons/"+id);
            HttpEntity<ContactPersonRto> requestEntity = new HttpEntity<>(contactPersonRto, httpHeaders);
            ResponseEntity<ContactPersonRto> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, ContactPersonRto.class);
            return responseEntity.getBody();
        } catch (URISyntaxException e) {
            throw new InvalidEndpointException();
        }
    }

}
