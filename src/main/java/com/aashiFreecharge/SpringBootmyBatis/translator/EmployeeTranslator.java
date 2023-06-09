package com.aashiFreecharge.SpringBootmyBatis.translator;

import com.aashiFreecharge.SpringBootmyBatis.commons.EmployeeRequest;
import com.aashiFreecharge.SpringBootmyBatis.commons.EmployeeResponse;
import com.aashiFreecharge.SpringBootmyBatis.dtos.EmployeeDto;
import com.aashiFreecharge.SpringBootmyBatis.model.EmployeeDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Getter
@Setter
@AllArgsConstructor
public class EmployeeTranslator {

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDto requestToDto(EmployeeRequest employeeRequest){
        return (modelMapper.map(employeeRequest, EmployeeDto.class));
    }

    public EmployeeDetails dtoToEntity(EmployeeDto dto){
        return modelMapper.map(dto, EmployeeDetails.class);
    }
    public EmployeeDto entityToDto(EmployeeDetails employeeDetails) {
        return modelMapper.map(employeeDetails, EmployeeDto.class);
    }

    public EmployeeResponse dtoToResponse(EmployeeDto dto) {
        return modelMapper.map(dto, EmployeeResponse.class);
    }

    public List<EmployeeDto> translateDetailsListToDto(
            List<EmployeeDetails> EmployeeDetailsList) {
        return Collections.singletonList(modelMapper.map(
                EmployeeDetailsList, EmployeeDto.class));
    }

    public List<EmployeeResponse> translateGetDtoListToResponse(
            List<EmployeeDto> EmployeeDtos) {
        List<EmployeeResponse> responses = new ArrayList<>();
        for(EmployeeDto emp : EmployeeDtos) {
            responses.add(modelMapper.map(emp, EmployeeResponse.class));
        }
        return responses;
    }

}
