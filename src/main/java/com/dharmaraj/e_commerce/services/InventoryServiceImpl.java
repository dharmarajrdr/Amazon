package com.dharmaraj.e_commerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dharmaraj.e_commerce.custom_exceptions.ProductNotFoundException;
import com.dharmaraj.e_commerce.custom_exceptions.UnAuthorizedAccessException;
import com.dharmaraj.e_commerce.custom_exceptions.UserNotFoundException;
import com.dharmaraj.e_commerce.models.Inventory;
import com.dharmaraj.e_commerce.models.Product;
import com.dharmaraj.e_commerce.models.User;
import com.dharmaraj.e_commerce.models.UserType;
import com.dharmaraj.e_commerce.repositories.InventoryRepository;
import com.dharmaraj.e_commerce.repositories.ProductRepository;
import com.dharmaraj.e_commerce.repositories.UserRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    private boolean isAdmin(int userId) throws UserNotFoundException {

        Optional<User> user = this.userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not fonud");
        }

        return user.get().getUserType().equals(UserType.ADMIN);
    }

    @Override
    public Inventory createOrUpdateInventory(int userId, int productId, int quantity)
            throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException {

        if (isAdmin(userId)) {
            Optional<Product> optionalProduct = this.productRepository.findProductById(productId);
            if (optionalProduct.isEmpty()) {
                throw new ProductNotFoundException("Product not found");
            }

            Optional<Inventory> optionalInventory = this.inventoryRepository.findInventoryByProductId(productId);
            Inventory inventory = null;
            if (optionalInventory.isEmpty()) {
                inventory = new Inventory();
                Product product = optionalProduct.get();
                inventory.setProduct(product);
                inventory.setQuantity(quantity);
            } else {
                inventory = optionalInventory.get();
                inventory.setQuantity(inventory.getQuantity() + quantity);
            }
            this.inventoryRepository.save(inventory);
            return inventory;

        } else {
            throw new UnAuthorizedAccessException("Permission denied to perform this action.");
        }
    }

    @Override
    public void deleteInventory(int userId, int productId) throws UserNotFoundException, UnAuthorizedAccessException {

        if (isAdmin(userId)) {
            Optional<Inventory> optionalInventory = this.inventoryRepository.findInventoryByProductId(productId);
            if (optionalInventory.isPresent()) {
                this.inventoryRepository.delete(optionalInventory.get());
            }
        } else {
            throw new UnAuthorizedAccessException("Permission denied to perform this action.");
        }
    }

}