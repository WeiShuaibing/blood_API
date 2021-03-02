package com.bishe.blood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Appointment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDao extends BaseMapper<Appointment> {

    @Update("update appointment set status = #{status} where appointment_id = #{appointmentId}")
    public int changeStatus(@Param("appointmentId") int appointmentId, @Param("status") int status);

    // 总献血量
    @Select("select sum(mm) as totalMM from appointment where user_id = #{userId} AND status in (2,3)")
    public int totalMM(@Param("userId") int userId);

}
