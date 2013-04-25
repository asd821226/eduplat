package com.yinzhi.eduplat.dao.specifications;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

import com.yinzhi.eduplat.entity.finance.Course;
import com.yinzhi.eduplat.entity.finance.Teacher;

public class FinanceSpecifications {
	
	public static Specification<Course> isGreaterThanEndDate(final String usrId) {
		return new Specification<Course>() {
			@Override
			public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				LocalDate today = new LocalDate();
//				Teacher teacher = new Teacher();
//				teacher.setFkUserId(usrId);
//				Predicate fkTeacherId = cb.equal(root.<Teacher> get("teacher"), teacher);
				Predicate greaterEndDate = cb.greaterThan(root.<Date> get("endDate"), today.toDateMidnight().toDate());

				return greaterEndDate;
//				return cb.and(fkTeacherId, greaterEndDate);
			}
		};
	}
	
}
