package org.devgateway.ocds.web.rest.controller.flags;

import io.swagger.annotations.ApiOperation;
import org.devgateway.ocds.persistence.mongo.FlaggedRelease;
import org.devgateway.ocds.persistence.mongo.flags.FlagsConstants;
import org.devgateway.ocds.web.rest.controller.request.YearFilterPagingRequest;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by mpostelnicu on 01/07/2017.
 */
@RestController
@CacheConfig(keyGenerator = "genericPagingRequestKeyGenerator", cacheNames = "genericPagingRequestJson")
@Cacheable
public class FlagI019ReleaseSearchController extends AbstractFlagReleaseSearchController {
    @Override
     protected String getFlagProperty() {
        return FlagsConstants.I019_VALUE;
    }

    @Override
    @ApiOperation(value = "Search releases by flag i019")
    @RequestMapping(value = "/api/flags/i019/releases",
            method = { RequestMethod.POST, RequestMethod.GET }, produces = "application/json")
    protected List<FlaggedRelease> releaseFlagSearch(@ModelAttribute @Valid YearFilterPagingRequest filter) {
        return super.releaseFlagSearch(filter);
    }
}
