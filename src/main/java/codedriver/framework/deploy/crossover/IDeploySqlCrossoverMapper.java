package codedriver.framework.deploy.crossover;

import codedriver.framework.deploy.dto.sql.DeploySqlVo;
import codedriver.framework.crossover.ICrossoverService;
import codedriver.framework.deploy.dto.sql.DeploySqlDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author longrf
 * @date 2022/4/28 2:10 下午
 */
public interface IDeploySqlCrossoverMapper extends ICrossoverService {

    DeploySqlDetailVo getAutoexecJobIdByDeploySqlDetailVo(DeploySqlDetailVo paramDeploySqlVo);

    List<DeploySqlDetailVo> getDeploySqlDetailList(@Param("sqlFileDetailVoList") List<DeploySqlDetailVo> sqlFileDetailVoList);

    List<DeploySqlDetailVo> getAllDeploySqlDetailList(DeploySqlDetailVo deployVersionSql);

    void updateDeploySqlDetailIsDeleteAndStatusAndMd5AndLcdById(@Param("status") String status, @Param("md5") String md5, @Param("id") Long id);

    void updateDeploySqlIsDeleteByIdList(@Param("idList") List<Long> idList);

    void insertDeploySqlDetail(DeploySqlDetailVo paramDeploySqlVo);

    void insertDeploySql(DeploySqlVo jobId);
}
