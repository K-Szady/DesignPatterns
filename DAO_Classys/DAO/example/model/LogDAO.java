package DAO.example.model;

import java.util.List;

public interface LogDAO {

	void addEntry(String message);

	List<Log> getEntry(int number);

}