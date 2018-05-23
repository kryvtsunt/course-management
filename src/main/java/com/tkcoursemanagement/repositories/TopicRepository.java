package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tkcoursemanagement.models.Topic;


public interface TopicRepository
extends CrudRepository<Topic, Integer>{}

