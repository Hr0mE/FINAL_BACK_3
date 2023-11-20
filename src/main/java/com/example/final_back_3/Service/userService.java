package com.example.final_back_3.Service;

import com.example.final_back_3.DTO.userDTO;
import com.example.final_back_3.Exceptions.userAlreadyExistsException;
import com.example.final_back_3.Exceptions.userListIsEmptyException;
import com.example.final_back_3.Exceptions.userNotFoundException;
import com.example.final_back_3.Model.userEntity;
import com.example.final_back_3.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class userService {

    //Обращение к реализации crud-комманд
    @Autowired
    private userRepository userRepo;

    //modelMapper обрезает излишки полей user под формат DTO класса.
    @Autowired
    private ModelMapper modelMapper;

    public userEntity registration(userEntity user) throws userAlreadyExistsException {
        if (userRepo.findById(user.getId() != null)){
            throw new userAlreadyExistsException("Пользователь уже существует");
        }
        return userRepo.save(user);
    }

    public List<userDTO> get_all() throws userListIsEmptyException{
        if (userRepo.count() == 0){
            throw new userListIsEmptyException("Список пользователей пуст, некого выводить");
        }
        List<userDTO> userEntities = Streamable.of(userRepo.findAll())
                                        .stream()
                                        .map(user -> modelMapper.map(user, userDTO.class))
                                        .toList();
        return userEntities;
    }

    public userDTO getById(Integer id) throws userNotFoundException,
                                        userListIsEmptyException {
        if (userRepo.count() == 0){
            throw new userListIsEmptyException("Список пользователей пуст, некого выводить");
        }
        var user = userRepo.findById(id);
        if (user.isEmpty()){
            throw new userNotFoundException("Пользователь не найден!");
        }
        return modelMapper.map(user, userDTO.class);
    }

    public Integer deleteById(Integer id){
        userRepo.deleteById(id);
        return id;
    }


}
