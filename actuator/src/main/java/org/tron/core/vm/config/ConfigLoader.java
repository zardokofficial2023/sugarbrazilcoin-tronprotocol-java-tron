package org.tron.core.vm.config;

import static org.tron.core.capsule.ReceiptCapsule.checkForEnergyLimit;

import lombok.extern.slf4j.Slf4j;
import org.tron.common.parameter.CommonParameter;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.core.vm.repository.Repository;

@Slf4j(topic = "VMConfigLoader")
public class ConfigLoader {

  //only for unit test
  public static boolean disable = false;

  public static void load(Repository repository) {
    if (!disable) {
      DynamicPropertiesStore ds = repository.getDynamicPropertiesStore();
      VMConfig.setVmTrace(CommonParameter.getInstance().isVmTrace());
      if (ds != null) {
        VMConfig.initVmHardFork(checkForEnergyLimit(ds));
        VMConfig.initAllowMultiSign(ds.getAllowMultiSign());
        VMConfig.initAllowTvmTransferTrc10(ds.getAllowTvmTransferTrc10());
        VMConfig.initAllowTvmConstantinople(ds.getAllowTvmConstantinople());
        VMConfig.initAllowTvmSolidity059(ds.getAllowTvmSolidity059());
        VMConfig.initAllowShieldedTRC20Transaction(ds.getAllowShieldedTRC20Transaction());
        VMConfig.initAllowTvmIstanbul(ds.getAllowTvmIstanbul());
        VMConfig.initAllowTvmFreeze(ds.getAllowTvmFreeze());
        VMConfig.initAllowTvmVote(ds.getAllowTvmVote());
        VMConfig.initAllowTvmLondon(ds.getAllowTvmLondon());
        VMConfig.initAllowTvmCompatibleEvm(ds.getAllowTvmCompatibleEvm());
        VMConfig.initAllowHigherLimitForMaxCpuTimeOfOneTx(
            ds.getAllowHigherLimitForMaxCpuTimeOfOneTx());
        VMConfig.initAllowTvmFreezeV2(ds.supportUnfreezeDelay() ? 1 : 0);
        VMConfig.initAllowOptimizedReturnValueOfChainId(
            ds.getAllowOptimizedReturnValueOfChainId());
        VMConfig.initAllowDynamicEnergy(ds.getAllowDynamicEnergy());
        VMConfig.initDynamicEnergyThreshold(ds.getDynamicEnergyThreshold());
        VMConfig.initDynamicEnergyIncreaseFactor(ds.getDynamicEnergyIncreaseFactor());
        VMConfig.initDynamicEnergyMaxFactor(ds.getDynamicEnergyMaxFactor());
        VMConfig.initAllowTvmShangHai(ds.getAllowTvmShangHai());
      }
    }
  }
}
