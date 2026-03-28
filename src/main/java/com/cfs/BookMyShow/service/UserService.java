package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.Model.User;
import com.cfs.BookMyShow.dto.UserDto;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserDto createUser(UserDto userDto)
    {
        User user=mapToEntity(userDto);
        User savedUser=userRepository.save(user);
        return mapToDto(savedUser);
    }

    public UserDto getUserById(Long id)
    {
        User user=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Use not found with id: "+id));
        return mapToDto(user);
    }

    public List<UserDto> getAllUsers()
    {
        List<User> users=userRepository.findAll();
        return users.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    //update user
    //delete user

    private User mapToEntity(UserDto userDto) {
        User user=new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return  user;
    }

    private UserDto mapToDto(User user)
    {
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;

    }
}
