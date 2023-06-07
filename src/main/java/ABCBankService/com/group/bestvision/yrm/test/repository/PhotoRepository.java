package ABCBankService.com.group.bestvision.yrm.test.repository;

import ABCBankService.com.group.bestvision.yrm.test.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long>, JpaSpecificationExecutor<PhotoEntity>
{

}
