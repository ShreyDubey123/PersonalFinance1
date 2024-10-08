import React, { createContext, useState, useContext, useEffect } from 'react';
import Axios_request from '../Axios_request';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    useEffect(() => {
        // Check the session status when the component mounts
        Axios_request("get",
            "/checkSession",
            {}
          )
            .then(response => {
                if (response.data.isAuthenticated) {
                    setIsAuthenticated(true);
                }
            })
            .catch(error => {
                //console.error('Session check error:', error);
            });
    }, []);

    const login = () => {
        setIsAuthenticated(true);
    };

    const logout = () => {
        setIsAuthenticated(false);
    };

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
