package com.dharmaraj.e_commerce.services;

import com.dharmaraj.e_commerce.custom_exceptions.UserNotFoundException;
import com.dharmaraj.e_commerce.models.Advertisement;

public interface AdsService {
    public Advertisement getAdvertisementForUser(int userId) throws UserNotFoundException;
}
