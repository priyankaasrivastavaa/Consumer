package com.collateral.service.impl;

import com.collateral.entity.Collateral;
import com.collateral.entity.Status;
import com.collateral.exception.CollateralException;
import com.collateral.repository.CollateralRepository;
import com.collateral.service.ICollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CollateralService implements ICollateralService {
    @Autowired
    private CollateralRepository repository;

    @Override
    public void addValuation(String collateralId) throws Exception {
        if (StringUtils.isEmpty(collateralId)) {
            throw new CollateralException("test");
        }
        long id = Long.parseLong(collateralId);
        Collateral entity = repository.findById(id);
        if (null == entity) {
            throw new CollateralException(String.
                    format("Collateral not forund for collateral id ; %s", collateralId));
        }
        entity.setValuationStatus(Status.COMPLETED.toString());
        repository.save(entity);
    }
}
