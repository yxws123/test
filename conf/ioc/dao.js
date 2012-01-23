var ioc = {
	dataSource : {
		type : "org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose : 'close'
		},
		fields : {
			driverClassName : 'net.sourceforge.jtds.jdbc.Driver',
			url : 'jdbc:jtds:sqlserver://localhost:1433;databasename=testDB',
			username : 'sa',
			password : 'kline'
		}
	},
	dao : {
		type : "org.nutz.dao.impl.NutDao",
		fields : {
			dataSource : {
				refer : 'dataSource'
			}
		}
	},
	dataSource4SDS : {
		type : "org.apache.commons.dbcp.BasicDataSource",
		events : {
			depose : 'close'
		},
		fields : {
			driverClassName : 'net.sourceforge.jtds.jdbc.Driver',
			url : 'jdbc:jtds:sqlserver://localhost:1433;databasename=klcdb',
			username : 'sa',
			password : 'kline'
		}
	},
	dao4SDS : {
		type : "org.nutz.dao.impl.NutDao",
		fields : {
			dataSource : {
				refer : 'dataSource4SDS'
			}
		}
	}
};