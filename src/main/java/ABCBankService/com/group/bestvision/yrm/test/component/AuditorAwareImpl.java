
/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 1:04 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String>
{
    @Override
    public Optional<String> getCurrentAuditor()
    {
        //TODO: Obtener el usurio logueado
        return Optional.empty();
//        //return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//        String userName = null;//((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//        return Optional.of((userName != null)? userName : "Default User");
    }
}
