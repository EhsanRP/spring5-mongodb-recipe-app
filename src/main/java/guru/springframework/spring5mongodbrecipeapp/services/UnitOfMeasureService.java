package guru.springframework.spring5mongodbrecipeapp.services;

import guru.springframework.spring5mongodbrecipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;


public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
