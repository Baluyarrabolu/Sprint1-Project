package com.balu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balu.entity.Address;
import com.balu.entity.Student;
import com.balu.exception.ResourceNotFoundException;
import com.balu.model.StudentDTO;
import com.balu.repository.AddressRepository;
import com.balu.repository.StudentRepository;
import com.balu.util.Converter;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private Converter converter;
	
	
	public String createStudent(Student student) {
		String message=null;
		studentRepository.save(student);
		if(student!=null)
		{
			message="Student details saved successfully";
		}
		return message;
	}
	
	public StudentDTO updateStudent(int id, Student student) {
		Student existingStudent =studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "ID", id));
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setPhone(student.getPhone());
		existingStudent.setEmail(student.getEmail());
		
		studentRepository.save(existingStudent);
		
		return converter.convertToStudentDTO(existingStudent);
	}
	
	public StudentDTO getStudentById(int id) {
		Student getS = studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "ID", id));
		return converter.convertToStudentDTO(getS);
	}
	
	public List<StudentDTO> getAllStudents() {
		List<Student> students=studentRepository.findAll();
		
		List<StudentDTO> sDTO = new ArrayList<>();
		for(Student s: students)
		{
			sDTO.add(converter.convertToStudentDTO(s));
		}
		return sDTO;
	}
	
	public String deleteStudentById(int id) {
		String message = null;
		java.util.Optional<Student> student= studentRepository.findById(id);
		if(student.isPresent())
		{
			studentRepository.deleteById(id);
			message = "Student details deleted successfully";
		}
		else
		{
			message="Student details not found!!";
		}
		return message;
	}

	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}
	
	public List<StudentDTO> getStudentByEmail(String email) {
		List<Student> stu = studentRepository.getStudentByEmail(email);
		List<StudentDTO> studentDTO = new ArrayList<>();
		for(Student s: stu)
		{
			studentDTO.add(converter.convertToStudentDTO(s));
		}
		return studentDTO;
	}

	public List<StudentDTO> getStudentByName(String studentName) {
		List<Student> students = studentRepository.getStudentByName(studentName);
		List<StudentDTO> studentDTO = new ArrayList<>();
		for(Student s: students)
		{
			studentDTO.add(converter.convertToStudentDTO(s));
		}
		return studentDTO;
	}

	public StudentDTO assignAddressToStudent(int id, int addressId) {
		Student student = studentRepository.findById(id).get();
		Address address = addressRepository.findById(addressId).get();
		student.setAddress(address);
		studentRepository.save(student);
		return converter.convertToStudentDTO(student);
	}


}
