import com.prefect.office.record.management.appl.facade.prefect.communityservice.CommunityServiceFacade;
import com.prefect.office.record.management.appl.facade.prefect.communityservice.impl.CommunityServiceFacadeImpl;
import com.prefect.office.record.management.appl.facade.prefect.offense.OffenseFacade;
import com.prefect.office.record.management.appl.facade.prefect.offense.impl.OffenseFacadeImpl;
import com.prefect.office.record.management.appl.facade.prefect.violation.ViolationFacade;
import com.prefect.office.record.management.appl.facade.prefect.violation.impl.ViolationFacadeImpl;
import com.prefect.office.record.management.data.dao.prefect.communityservice.CommunityServiceDao;
import com.prefect.office.record.management.data.dao.prefect.communityservice.impl.CommunityServiceDaoImpl;
import com.prefect.office.record.management.data.dao.prefect.offense.OffenseDao;
import com.prefect.office.record.management.data.dao.prefect.offense.impl.OffenseDaoImpl;
import com.prefect.office.record.management.data.dao.prefect.violation.ViolationDao;
import com.prefect.office.record.management.data.dao.prefect.violation.impl.ViolationDaoImpl;
import com.student.information.management.data.student.dao.impl.StudentDaoImpl;

public class PrefectOfficeRecordMgtApplication {

private CommunityServiceFacade communityserviceFacade;
    private OffenseFacade offenseFacade;
    private ViolationFacade violationFacade;
public PrefectOfficeRecordMgtApplication(){
    CommunityServiceDao communityserviceDaoImpl = new CommunityServiceDaoImpl();
    this.communityserviceFacade = new CommunityServiceFacadeImpl(communityserviceDaoImpl);

    ViolationDao violationDaoImpl = new ViolationDaoImpl();
    this.violationFacade = new ViolationFacadeImpl(violationDaoImpl);

    OffenseDao offenseDaoImpl = new OffenseDaoImpl();
    this.offenseFacade = new OffenseFacadeImpl(offenseDaoImpl);
}

    public CommunityServiceFacade getCommunityserviceFacade() {
        return communityserviceFacade;
    }
    public OffenseFacade getOffenseFacade() {
        return offenseFacade;
    }
    public ViolationFacade getViolationFacade() {
        return violationFacade;
    }
}

