import java.util.ArrayList;



class PropertyData {
	public ArrayList<Property> properties = new ArrayList<Property>();
	
	public PropertyData() {
		Property m_a = new Property("purple", "Mediterranean avenue");
		m_a.price = 60;
		m_a.mortgage = 30;
		m_a.housePrice = 50;
		m_a.houseRent = new int[]{2, 10, 30, 90, 160};
		m_a.hotelRent = 250;
		properties.add(m_a);
		
		Property b_a = new Property("purple", "Baltic avenue");
		b_a.price = 60;
		b_a.mortgage = 30;
		b_a.housePrice = 50;
		b_a.houseRent = new int[]{4, 20, 60, 180, 320};
		b_a.hotelRent = 450;
		properties.add(b_a);
		
		Property o_a = new Property("light blue", "Oriental avenue");
		o_a.price = 100;
		o_a.mortgage = 50;
		o_a.housePrice = 50;
		o_a.houseRent = new int[]{6, 30, 90, 270, 400};
		o_a.hotelRent = 550;
		properties.add(o_a);
		
		Property v_a = new Property("light blue", "Vermont avenue");
		v_a.price = 100;
		v_a.mortgage = 50;
		v_a.housePrice = 50;
		v_a.houseRent = new int[]{6, 30, 90, 270, 400};
		v_a.hotelRent = 550;
		properties.add(v_a);
		
		Property c_a = new Property("light blue", "Conneticut avenue");
		c_a.price = 120;
		c_a.mortgage = 60;
		c_a.housePrice = 50;
		c_a.houseRent = new int[]{8, 40, 100, 300, 450};
		c_a.hotelRent = 600;
		properties.add(c_a);
		
		Property s_c_p = new Property("Magenta", "St. Charles place");
		s_c_p.price = 140;
		s_c_p.mortgage = 70;
		s_c_p.housePrice = 100;
		s_c_p.houseRent = new int[]{10, 50, 150, 450, 625};
		s_c_p.hotelRent = 750;
		properties.add(s_c_p);
		
		Property s_a = new Property("Magenta", "States avenue");
		s_a.price = 140;
		s_a.mortgage = 70;
		s_a.housePrice = 100;
		s_a.houseRent = new int[]{10, 50, 150, 450, 625};
		s_a.hotelRent = 750;
		properties.add(s_a);
		
		
		Property vi_a = new Property("Magenta", "Virginia avenue");
		vi_a.price = 160;
		vi_a.mortgage = 80;
		vi_a.housePrice = 100;
		vi_a.houseRent = new int[]{12, 60, 180, 500, 700};
		vi_a.hotelRent = 900;
		properties.add(vi_a);
		
		Property s_j_p = new Property("Orange", "St. James place");
		s_j_p.price = 180;
		s_j_p.mortgage = 90;
		s_j_p.housePrice = 100;
		s_j_p.houseRent = new int[]{14, 70, 200, 550, 750};
		s_j_p.hotelRent = 950;
		properties.add(s_j_p);
		
		Property t_a = new Property("Orange", "Tennessee avenue");
		t_a.price = 180;
		t_a.mortgage = 90;
		t_a.housePrice = 100;
		t_a.houseRent = new int[]{14, 70, 200, 550, 750};
		t_a.hotelRent = 950;
		properties.add(t_a);
		
		Property n_y_a = new Property("Orange", "New York avenue");
		n_y_a.price = 200;
		n_y_a.mortgage = 100;
		n_y_a.housePrice = 100;
		n_y_a.houseRent = new int[]{16, 80, 220, 600, 800};
		n_y_a.hotelRent = 1000;
		properties.add(n_y_a);
		
		Property k_a = new Property("red", "Kentucky avenue");
		k_a.price = 220;
		k_a.mortgage = 110;
		k_a.housePrice = 150;
		k_a.houseRent = new int[]{18, 90, 250, 700, 875};
		k_a.hotelRent = 1050;
		properties.add(k_a);

	}
	
}