package com.informatics.practice.app.view;
import com.informatics.practice.app.common.security.JwtTokenUtil;
import com.informatics.practice.app.entity.User;
import com.informatics.practice.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
@RestController()
@RequestMapping("/security")
public class SecurityController {

    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    public SecurityController(UserService userService, JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<String> createAuthenticationToken(@RequestBody User user) {

        final UserDetails userDetails = userService
                .loadUserByUsername(user.getUsername());

        try {
            authenticate(user.getUsername(), user.getPassword());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.OK).body("Login Failed");
        }

        final String token = jwtTokenUtil.generateToken(userDetails);

        userService.saveToken(user.getUsername(), token);

        return ResponseEntity.ok(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
