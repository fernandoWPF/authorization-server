package br.com.fwpf.authorizationserver.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

@Document(collection = "user")
public class Client implements ClientDetails {

	private static final long serialVersionUID = 1L;
	private static final Set<String> SCOPE = new HashSet<>(Arrays.asList("all"));
	private static final Set<String> GRANT_TYPE = new HashSet<>(Arrays.asList("client_credentials"));

	@Value("${token.expires-in}")
	private Integer expiresIn;

	@Id
	private String id;
	private String clientId;
	private String secret;
	private Collection<Authority> authorities;

	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		return new HashSet<>();
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return secret;
	}

	@Override
	public boolean isScoped() {
		return false;
	}

	@Override
	public Set<String> getScope() {
		return SCOPE;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return GRANT_TYPE;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return new HashSet<>();
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		final Set<GrantedAuthority> setAuthorities = new HashSet<>();
		authorities.stream()
				.forEach(authority -> setAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority())));
		return setAuthorities;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return expiresIn;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return null;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return new HashMap<>();
	}

}
