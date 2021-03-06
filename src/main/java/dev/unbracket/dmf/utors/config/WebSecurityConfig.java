//package dev.unbracket.dmf.utors.config;
//
//import ao.gov.maptss.sigcpape.helper.Constants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * @author Domingos M. Fernando
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private JwtUserDetailsService jwtUserDetailsService;
//
//    @Autowired
//    private JwtAuthenticationEntryPoint unauthorizedHandler;
//
//    @Autowired
//    private CustomPasswordEncoder pwdEncoder;
//
//    private static final String[] AUTH_WHITELIST = {
//        "/v2/api-docs",
//        "/v3/api-docs",
//        "/v3/api-docs/swagger-config",
//        "/sigpape-v2-docs.html",
//        "/sigcpape/v1/api/file/showdirect",
//        "/swagger-ui.html",
//        "/swagger-resources",
//        "/swagger-resources/**",
//        "/configuration/ui",
//        "/configuration/security",
//        "/swagger-ui/index.html",
//        "/swagger-ui/**",
//        "/webjars/**",
//        "/index.html",
//        "/js/**",
//        "/css/**"
//    };
//    private static final String[] ALL_AUTHORITIES = {
//        "ROOT",
//        "ADMIN",
//        "PELOURO_ADMIN",
//        "EDIT",
//        "P_FOCAIS",
//        "VIEW",
//        "USER"
//    };
//    private static final String[] ADMIN_AUTHORITIES = {
//        "ROOT",
//        "ADMIN",
//        "PELOURO_ADMIN",
//        "EDIT",
//        "P_FOCAIS"
//    };
//    private static final String[] PELOURO_AUTHORITIES = {
//        "PELOURO_ADMIN",
//        "EDIT",
//        "VIEW",
//        "P_FOCAIS",
//        "USER"
//    };
//    private static final String[] EDIT_AUTHORITIES = {
//        "EDIT",
//        "P_FOCAIS",
//        "VIEW",
//        "USER"
//    };
//    private static final String[] VIEW_AUTHORITIES = {
//        "VIEW",
//        "USER"
//    };
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(pwdEncoder.getPasswordEncoder());
//    }
//
//    @Bean
//    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
//        return new JwtAuthenticationFilter();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().
//                authorizeRequests()
//                .antMatchers(AUTH_WHITELIST).permitAll()
//                .antMatchers(HttpMethod.POST, Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + "/auth/login").permitAll()
//                .antMatchers(HttpMethod.POST, Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + "/auth/signup").permitAll()
//                //
//                .antMatchers(HttpMethod.GET, Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + "/**").hasAnyAuthority(ALL_AUTHORITIES)
//                .antMatchers(Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + Constants.URL_PATHS_AUTH + "/**").hasAnyAuthority(ALL_AUTHORITIES)
//                .antMatchers(Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + Constants.URL_PATHS_AUTH + "/**").hasAnyAuthority(ALL_AUTHORITIES)
//                //
//                //Permi????es para o Verbo POST Para  Candidate
//                .antMatchers(HttpMethod.POST, Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + Constants.URL_PATHS_CAND + "/**").hasAnyAuthority(ALL_AUTHORITIES)
//                .antMatchers(HttpMethod.POST, Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + Constants.URL_PATHS_CAND).hasAnyAuthority(ALL_AUTHORITIES)
//                //
//                .antMatchers(HttpMethod.POST, Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + "/**").hasAnyAuthority(ADMIN_AUTHORITIES)
//                .antMatchers(HttpMethod.PUT, Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + "/**").hasAnyAuthority(ADMIN_AUTHORITIES)
//                .antMatchers(HttpMethod.DELETE, Constants.DEFAULT_APP_URL_BASE + Constants.DEFAULT_APP_API_VERSION + Constants.APP_NAME + "/**").hasAnyAuthority(ADMIN_AUTHORITIES)
//                //
//                .and()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class
//        );
//    }
//
//    @Bean
//    public FilterRegistrationBean platformCorsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration configAutenticacao = new CorsConfiguration();
//        configAutenticacao.setAllowCredentials(true);
//        configAutenticacao.addAllowedOriginPattern("*");
////
//        configAutenticacao.addAllowedOriginPattern("https://www.api-dev.gov.ao/**");
//        configAutenticacao.addAllowedOriginPattern("https://api-dev.pape.gov.ao/**");
//        configAutenticacao.addAllowedOriginPattern("https://www.api-dev.gov.ao:8082/**");
//        configAutenticacao.addAllowedOriginPattern("https://api-dev.pape.gov.ao:8082/**");
//        configAutenticacao.addAllowedOriginPattern("https://www.pape.gov.ao/**");
//        configAutenticacao.addAllowedOriginPattern("https://pape.gov.ao/**");
//        configAutenticacao.addAllowedOriginPattern("https://www.homologacao.pape.gov.ao/**");
//        configAutenticacao.addAllowedOriginPattern("https://homologacao.pape.gov.ao/**");
//        configAutenticacao.addAllowedOriginPattern("https://admin.pape.gov.ao:3082/**");
//        configAutenticacao.addAllowedOriginPattern("https://www.admin.pape.gov.ao:3082/**");
//        configAutenticacao.addAllowedOriginPattern("https://admin-homologacao.pape.gov.ao:3082/**");
//        configAutenticacao.addAllowedOriginPattern("https://www.admin-homologacao.pape.gov.ao:3082/**");
////
//        configAutenticacao.addAllowedHeader("Authorization");
//        configAutenticacao.addAllowedHeader("Content-Type");
//        configAutenticacao.addAllowedHeader("Accept");
//        configAutenticacao.addAllowedMethod("POST");
//        configAutenticacao.addAllowedMethod("GET");
//        configAutenticacao.addAllowedMethod("DELETE");
//        configAutenticacao.addAllowedMethod("PUT");
//        configAutenticacao.addAllowedMethod("OPTIONS");
//        configAutenticacao.setMaxAge(3600L);
//        source.registerCorsConfiguration("/**", configAutenticacao);
//
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(-110);
//        return bean;
//    }
//}
