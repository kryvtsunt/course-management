package com.tkcoursemanagement.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tkcoursemanagement.models.User;
import com.tkcoursemanagement.models.Widget;;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{
	
}
