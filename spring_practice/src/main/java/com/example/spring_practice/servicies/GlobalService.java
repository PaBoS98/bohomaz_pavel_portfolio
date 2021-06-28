package com.example.spring_practice.servicies;

import com.example.spring_practice.dto.PersonFullDto;
import com.example.spring_practice.entity.Activity;
import com.example.spring_practice.entity.Person;
import com.example.spring_practice.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

@Service
public class GlobalService {

    private GlobalRepository globalRepository;

    @Autowired
    public void setGlobalRepository(GlobalRepository globalRepository) {
        this.globalRepository = globalRepository;
    }

    public List<PersonFullDto> get() {

        return getPerson();
    }

    @Transactional(Transactional.TxType.NEVER)
    public List<PersonFullDto> getPerson() {
        List<Person> persons = globalRepository.findAllPerson();
        List<Activity> activities = getActivity();
        List<PersonFullDto> dto = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            PersonFullDto d = new PersonFullDto();
            d.setId(persons.get(i).getId());
            d.setUserName(persons.get(i).getName());
            d.setActivityName(activities.get(i).getName());
            dto.add(d);
        }
        return dto;
    }

    @Transactional
    public List<Activity> getActivity(){
        return new ArrayList<>(globalRepository.findAllActivity());
    }
}
