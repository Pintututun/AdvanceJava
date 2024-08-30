package playerDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddPlayersDAO {
	private int k = 0;

	public int insert(PlayerBean pb) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Player200 values(?,?,?)");
			ps.setString(1, pb.getId());
			ps.setString(2, pb.getName());
			ps.setBinaryStream(3, pb.getImg());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
