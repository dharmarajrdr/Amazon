package com.dharmaraj.e_commerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dharmaraj.e_commerce.custom_exceptions.UserNotFoundException;
import com.dharmaraj.e_commerce.models.Advertisement;
import com.dharmaraj.e_commerce.models.Preference;
import com.dharmaraj.e_commerce.models.User;
import com.dharmaraj.e_commerce.repositories.AdvertisementRepository;
import com.dharmaraj.e_commerce.repositories.UserRepository;

@Service
public class AdsServiceImpl implements AdsService {

    private UserRepository userRepository;
    private AdvertisementRepository advertisementRepository;

    public AdsServiceImpl(AdvertisementRepository advertisementRepository, UserRepository userRepository) {
        this.advertisementRepository = advertisementRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Advertisement getAdvertisementForUser(int userId) throws UserNotFoundException {

        Optional<User> optionalUser = this.userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        User user = optionalUser.get();

        List<Preference> userPreferences = user.getPreferences();

        Advertisement advertisement;

        if(userPreferences.size() == 0) {

            advertisement = this.advertisementRepository.findAll().get(0);
        } else {

            advertisement = this.advertisementRepository.findByPreference(userPreferences.get(userPreferences.size() - 1));
        }

        return advertisement;
    }

}
