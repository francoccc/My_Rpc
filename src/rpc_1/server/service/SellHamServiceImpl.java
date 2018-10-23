package rpc_1.server.service;

import rpc_1.bean.Hamburger;
import rpc_1.service.SellHamService;

public class SellHamServiceImpl implements SellHamService {

    @Override
    public Hamburger prepareOneHam() {
        Hamburger hamburger = new Hamburger();
        hamburger.setMeat("beaf");
        return hamburger;
    }
}
