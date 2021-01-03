package com.codese.SpringBootBackendBoilderplate.controller;


import com.codese.SpringBootBackendBoilderplate.config.security.jwt.CustomUserDetail;
import com.codese.SpringBootBackendBoilderplate.config.security.jwt.JwtAuthenticationRequest;
import com.codese.SpringBootBackendBoilderplate.config.security.jwt.JwtAuthenticationResponse;
import com.codese.SpringBootBackendBoilderplate.config.security.jwt.JwtTokenProvider;
import com.codese.SpringBootBackendBoilderplate.helper.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<ResponseBuilder<JwtAuthenticationResponse>> authenticateUser(@RequestBody JwtAuthenticationRequest request) {
        // Authentication sẽ lấy user từ username người dùng truyền vào từ hàm loadUserByUserName() (config trong WebSecurityConfig)

        // loadUserByUserName() trả về 1 đối tượng là customUserDetail
        // Class CustomUserDetail là 1 class implement userDetail, mình đã map username và password vào hàm get rồi

        // >> đó là lý do tại sao 4 dòng dưới nó tự check được password người dùng và trong database
        // (so sánh password từ request và password từ customUserDetail)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken((CustomUserDetail) authentication.getPrincipal());
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(jwt);
        return ResponseEntity.ok(ResponseBuilder.buildResponse(jwtAuthenticationResponse));
    }

}
