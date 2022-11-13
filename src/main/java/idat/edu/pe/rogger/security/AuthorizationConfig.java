package idat.edu.pe.rogger.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
    private JwtTokenStore tokenStore;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;
    
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // TODO Auto-generated method stub
        super.configure(security);
    }

   @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        
        clients.inMemory()
            .withClient("rogger")
            .secret(new BCryptPasswordEncoder().encode("123"))
            .authorizedGrantTypes("password", "authorization_code", "refresh_token") //politica
            .scopes("read","write","trust") //roles
            .accessTokenValiditySeconds(1*60*60) //login 1h
            .refreshTokenValiditySeconds(5*60*60); //refresh
    }

   @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
       TokenEnhancerChain chain = new TokenEnhancerChain(); 
	   chain.setTokenEnhancers(Arrays.asList(new TokenEnhancer() {
		
		@Override
		public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
			
			Map<String, Object> indormacionAdicional = new HashMap<>();
			indormacionAdicional.put("codigo", "at76324897");
			indormacionAdicional.put("alumno", "Rogger");
			
			DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(accessToken);
			token.setAdditionalInformation(indormacionAdicional);
			
			return token;
		}
	   }, accessTokenConverter));
	   
	   endpoints.tokenStore(tokenStore) //guardar el JSON que muestra el token
            .authenticationManager(authenticationManager)
	   		.accessTokenConverter(accessTokenConverter)
	   		.tokenEnhancer(chain);
    }
	
}
