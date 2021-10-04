package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Import({TranslatorConfig.class})
//@Configuration
//@ComponentScan(basePackages = {
//        "za.ac.nwu.ac.logic.flow.impl"
//})
@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

//    @Override
//    public List<AccountTypeDto> getAllAccountTypes(){
//        return accountTypeTranslator.getAllAccountTypes();
//
//    }

    public List<AccountTypeDto> getAllAccountTypes(){
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        accountTypeDtos.add(new AccountTypeDto("MILES", "Miles", LocalDate.now()));
        return accountTypeDtos;
    }
}
