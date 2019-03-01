package com.idemia.HiringProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.idemia.HiringProject.Entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

}