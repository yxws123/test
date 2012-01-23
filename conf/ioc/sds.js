var ioc = {
	// Payer
	payerService : {
		type : "com.kline.sds.service.impl.PayerServiceImpl",
		fields : {
			dao : {
				refer : 'dao4SDS'
			}
		}
	},
	payerModule : {
		type : "com.kline.sds.ui.PayerModule",
		fields : {
			payerService : {
				refer : 'payerService'
			}
		}
	}
};
