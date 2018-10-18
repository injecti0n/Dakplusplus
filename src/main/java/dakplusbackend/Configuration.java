package dakplusbackend;

import dakplusbackend.service.ContractService;
import dakplusbackend.service.EmployeeService;
import dakplusbackend.service.WorkingDayService;
import dakplusbackend.service.stubs.ContractServiceStub;
import dakplusbackend.service.stubs.DataProcess;
import dakplusbackend.service.stubs.EmployeeServiceStub;
import dakplusbackend.service.stubs.WorkingDayServiceStub;

public class Configuration {
    /**
     * The {@link #config(ServiceBinder)} method is used to configure the {@link ServiceBinder}.<p>
     * Replace the second parameters with your own classes. The {@link #config(ServiceBinder)} will take care of the rest.
     * <p><p>
     * @param binder The service binder will inject itself here. Don't worry about it.
     */
    protected static void config(ServiceBinder binder) {
        binder.bind(EmployeeService.class, DataProcess.class);
        binder.bind(ContractService.class, ContractServiceStub.class);
        binder.bind(WorkingDayService.class, WorkingDayServiceStub.class);
    }
}
