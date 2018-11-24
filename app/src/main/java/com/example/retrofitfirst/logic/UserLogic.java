package com.example.retrofitfirst.logic;

import android.util.Log;
import android.widget.Toast;

import com.example.retrofitfirst.AuthorizationActivity;
import com.example.retrofitfirst.RegistrationActivity;
import com.example.retrofitfirst.api.UserAPI;
import com.example.retrofitfirst.entity.user.UserLogInPOST;
import com.example.retrofitfirst.entity.user.UserLogInResponse;
import com.example.retrofitfirst.entity.user.UserRegResponse;
import com.example.retrofitfirst.entity.user.UserRegPOST;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class UserLogic {

    /**
     * Send JSON to reg user and get response from server.
     *
     * @param userAPI corresponding user api for interaction with server;
     * @param name    user name;
     * @param mail    user mail;
     * @param pass    user password.
     */
    public static void regUser(UserAPI userAPI, String name, String mail, String pass, RegistrationActivity registrationActivity) {

        UserRegPOST userRegPOST = new UserRegPOST();

        userRegPOST.setName(name);
        userRegPOST.setMail(mail);
        userRegPOST.setPass(pass);

        userAPI.regUser(userRegPOST)
                .enqueue(new Callback<UserRegResponse>() {
                    @Override
                    public void onResponse(Call<UserRegResponse> call, Response<UserRegResponse> response) {

                        if (response.isSuccessful()) {
                            registrationActivity.GoToAuthorization();
                        } else {
                            Toast toast = Toast.makeText(registrationActivity.getApplicationContext(),
                                    response.message(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserRegResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    /**
     * Send JSON to log in user and get response from server.
     *
     * @param userAPI               corresponding user api for interaction with server;
     * @param username              user name;
     * @param password              user password.
     * @param authorizationActivity start list of dinos if authorization correct
     */
    public static void logInUser(UserAPI userAPI, String username, String password, AuthorizationActivity authorizationActivity) {

        UserLogInPOST userLogInPOST = new UserLogInPOST();

        userLogInPOST.setUsername(username);
        userLogInPOST.setPassword(password);

        userAPI.logInUser(userLogInPOST)

                // Asynchronously send the request and notify {@code callback} of its response form server.
                .enqueue(new Callback<UserLogInResponse>() {
                    @Override
                    public void onResponse(Call<UserLogInResponse> call, Response<UserLogInResponse> response) {

                        if (response.isSuccessful()) {
                            MainLogic.getInstance().setUserLogInResponse(response.body());
                            authorizationActivity.startListDino();

                        } else {
                            Toast toast = Toast.makeText(authorizationActivity.getApplicationContext(),
                                    response.message(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserLogInResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
