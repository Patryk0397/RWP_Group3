import pymysql

conn = pymysql.connect(host = 'gompare.000webhostapp.com',
                       port = 3306, user = 'id1067753_rwp',
                       passwd = 'group3', db = 'id1067753_gompare')

c = conn.cursor()

c.execute("CREATE TABLE IF NOT EXISTS users (user varchar(30), password varchar(30))")

conn.commit()

c.close()
 
