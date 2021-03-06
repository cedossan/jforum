/*
 * Copyright (C) 2014 valerian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package at.graphes.jforum.pages;

import at.graphes.jforum.entities.User;
import at.graphes.jforum.services.auth.AuthenticationException;
import at.graphes.jforum.services.auth.AuthenticationService;
import at.graphes.jforum.services.domain.UserDAO;
import java.util.Date;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author valerian
 */
public class Login  {
    
    @Property
    private String nickname;
    
    @Property
    private String password;
    
    @Inject
    private AuthenticationService auth;
    
    @Inject
    private UserDAO userDAO;
    
    @InjectComponent("password")
    private PasswordField passwordField;
    
    @Component
    private Form loginForm;
    
    void onValidateFromLoginForm()
    {
        try {
            auth.tryLogin(nickname, password);
            User u = auth.getLoggedUser();
            u.setLastLogDate(new Date());
            userDAO.save(u);
            
        } catch(AuthenticationException e) {
            loginForm.recordError(e.getMessage());
        }
    }
    
    Object onSuccess() {
        return Index.class;
    }
    
}
