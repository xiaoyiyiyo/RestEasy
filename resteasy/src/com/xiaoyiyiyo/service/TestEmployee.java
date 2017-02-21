package com.xiaoyiyiyo.service;

import com.xiaoyiyiyo.bean.Employee;
import com.xiaoyiyiyo.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by xiaoyiyiyo on 2017/1/31.
 */
@Service
@Path("/")
public class TestEmployee{

    @GET
    @Path("/e/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeByEmployeeId(@PathParam("param") int employeeId) {
        Session session = HibernateUtil.getSession();
        String hql = "from Employee where employeeId = :employee_Id";
        Query query = session.createQuery(hql);
        query.setInteger("employee_Id",employeeId);
        Employee employee = (Employee) query.uniqueResult();
        HibernateUtil.closeSession();
        return employee;
    }


}
