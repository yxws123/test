var ioc = {
	// Service Start
	// BlMaster
	blMasterService : {
		type : "com.kline.blconfirm.service.impl.BlMasterServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	// BlMasterA
	blMasterAService : {
		type : "com.kline.blconfirm.service.impl.BlMasterAServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	// BlCargo
	blCargoService : {
		type : "com.kline.blconfirm.service.impl.BlCargoServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	// BlMarkNo
	blMarkNoService : {
		type : "com.kline.blconfirm.service.impl.BlMarkNoServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	// BlContainer
	blContainerService : {
		type : "com.kline.blconfirm.service.impl.BlContainerServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	// BlCustomerRef
	blCustomerRefService : {
		type : "com.kline.blconfirm.service.impl.BlCustomerRefServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	// BlConfirmStatus
	blConfirmStatusService : {
		type : "com.kline.blconfirm.service.impl.BlConfirmStatusServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	// Service End
	// Module Start
	blMasterModule : {
		type : "com.kline.blconfirm.ui.BlMasterModule",
		fields : {
			blMasterService : {
				refer : 'blMasterService'
			}
		}
	},
	blMasterBModule : {
		type : "com.kline.blconfirm.ui.BlMasterBModule",
		fields : {
			blMasterAService : {
				refer : 'blMasterAService'
			}
		}
	},
	blCargoModule : {
		type : "com.kline.blconfirm.ui.BlCargoModule",
		fields : {
			blCargoService : {
				refer : 'blCargoService'
			}
		}
	},
	blMarkNoModule : {
		type : "com.kline.blconfirm.ui.BlMarkNoModule",
		fields : {
			blMarkNoService : {
				refer : 'blMarkNoService'
			}
		}
	}
	// Module End
};
