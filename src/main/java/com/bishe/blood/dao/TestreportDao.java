package com.bishe.blood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Testreport;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TestreportDao extends BaseMapper<Testreport> {

    @Update("update testreport set status = #{status} where appointment_id = #{appointmentId}")
    public int changeStatus(@Param("appointmentId") int appointmentId, @Param("status") int status);

}
