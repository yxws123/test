var ioc = {
	// BkgMaster
	bookingService : {
		type : "com.kline.booking.service.impl.BookingServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	},
	bookingModule : {
		type : "com.kline.booking.ui.BookingModule",
		fields : {
			bkgMasterService : {
				refer : 'bookingService'
			}
		}
	},
	// BkgCargo
	bkgCargoService : {
		type : "com.kline.booking.service.impl.BkgCargoServiceImpl",
		fields : {
			dao : {
				refer : 'dao'
			}
		}
	}
};
