package online.iizvv.dao;

import online.iizvv.pojo.DevicePackage;
import org.apache.ibatis.annotations.*;

/**
 * @author ：iizvv
 * @date ：Created in 2019-09-04 20:53
 * @description：设备与安装包关联表
 * @modified By：
 * @version: 1.0
 */
@Mapper
public interface DPDao {

    /**
     * create by: iizvv
     * description: 设置设备是否可用
     * create time: 2019-09-04 21:35
     *

     * @return int
     */
    @Update("UPDATE device_package SET is_use = #{isUse} WHERE device_id = #{deviceId}")
    int updateDPIsUse(long deviceId, boolean isUse);

    /**
     * create by: iizvv
     * description: 写入关联表
     * create time: 2019-09-04 20:57
     *

     * @return int
     */
    @Insert("INSERT INTO device_package (device_id, package_id) VALUES (#{deviceId}, #{packageId})")
    int insertDP(long deviceId, long packageId);

    /**
     * create by: iizvv
     * description: 查询绑定信息
     * create time: 2019-09-04 21:00
     *

     * @return DevicePackage
     */
    @Select("SELECT * FROM device_package WHERE device_id = #{deviceId} AND package_id = #{packageId} AND is_use = true")
    DevicePackage getDPByIds(long deviceId, long packageId);

    /**
     * create by: iizvv
     * description: 获取绑定数量
     * create time: 2019-09-04 21:00
     *

     * @return DevicePackage
     */
    @Select("SELECT COUNT(id) FROM device_package WHERE device_id = #{deviceId} AND package_id = #{packageId} AND is_use = true")
    long getDPCountByIds(long deviceId, long packageId);


    /**
     * create by: iizvv
     * description: 删除关联信息
     * create time: 2019-09-04 21:03
     *

     * @return int
     */
    @Delete("DELETE FROM device_package WHERE device_id = #{deviceId} AND package_id = #{packageId}")
    int deleteDPByIds(long deviceId, long packageId);

}
