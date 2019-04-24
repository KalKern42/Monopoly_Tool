import java.util.ArrayList;



public class PropertyData {
	public ArrayList<Property> propertyList = new ArrayList<Property>();
	

	public Property get(String name) {		
		for (Property property : propertyList) {
			if (property.name.equalsIgnoreCase(name)) {
				return property;
			}
		}
		return null;
	}
	
	public ArrayList<Property> getByColor(String color) {
		ArrayList<Property> colored = new ArrayList<Property>();
		
		for (Property property : propertyList) {
			if (property.color.equalsIgnoreCase(color)) {
				colored.add(property);
			}
		}
		return colored;
	}
	
	public PropertyData() {
		Property m_a = new Property("brown", "Mediterranean avenue");
		m_a.price = 60;
		m_a.mortgage = 30;
		m_a.housePrice = 50;
		m_a.houseRent = new int[]{2, 10, 30, 90, 160};
		m_a.hotelRent = 250;
		propertyList.add(m_a);
		
		Property b_a = new Property("brown", "Baltic avenue");
		b_a.price = 60;
		b_a.mortgage = 30;
		b_a.housePrice = 50;
		b_a.houseRent = new int[]{4, 20, 60, 180, 320};
		b_a.hotelRent = 450;
		propertyList.add(b_a);
		
		Property o_a = new Property("light blue", "Oriental avenue");
		o_a.price = 100;
		o_a.mortgage = 50;
		o_a.housePrice = 50;
		o_a.houseRent = new int[]{6, 30, 90, 270, 400};
		o_a.hotelRent = 550;
		propertyList.add(o_a);
		
		Property v_a = new Property("light blue", "Vermont avenue");
		v_a.price = 100;
		v_a.mortgage = 50;
		v_a.housePrice = 50;
		v_a.houseRent = new int[]{6, 30, 90, 270, 400};
		v_a.hotelRent = 550;
		propertyList.add(v_a);
		
		Property c_a = new Property("light blue", "Conneticut avenue");
		c_a.price = 120;
		c_a.mortgage = 60;
		c_a.housePrice = 50;
		c_a.houseRent = new int[]{8, 40, 100, 300, 450};
		c_a.hotelRent = 600;
		propertyList.add(c_a);
		
		Property s_c_p = new Property("Magenta", "St. Charles place");
		s_c_p.price = 140;
		s_c_p.mortgage = 70;
		s_c_p.housePrice = 100;
		s_c_p.houseRent = new int[]{10, 50, 150, 450, 625};
		s_c_p.hotelRent = 750;
		propertyList.add(s_c_p);
		
		Property s_a = new Property("Magenta", "States avenue");
		s_a.price = 140;
		s_a.mortgage = 70;
		s_a.housePrice = 100;
		s_a.houseRent = new int[]{10, 50, 150, 450, 625};
		s_a.hotelRent = 750;
		propertyList.add(s_a);
		
		Property vi_a = new Property("Magenta", "Virginia avenue");
		vi_a.price = 160;
		vi_a.mortgage = 80;
		vi_a.housePrice = 100;
		vi_a.houseRent = new int[]{12, 60, 180, 500, 700};
		vi_a.hotelRent = 900;
		propertyList.add(vi_a);
		
		Property s_j_p = new Property("Orange", "St. James place");
		s_j_p.price = 180;
		s_j_p.mortgage = 90;
		s_j_p.housePrice = 100;
		s_j_p.houseRent = new int[]{14, 70, 200, 550, 750};
		s_j_p.hotelRent = 950;
		propertyList.add(s_j_p);
		
		Property t_a = new Property("Orange", "Tennessee avenue");
		t_a.price = 180;
		t_a.mortgage = 90;
		t_a.housePrice = 100;
		t_a.houseRent = new int[]{14, 70, 200, 550, 750};
		t_a.hotelRent = 950;
		propertyList.add(t_a);
		
		Property n_y_a = new Property("Orange", "New York avenue");
		n_y_a.price = 200;
		n_y_a.mortgage = 100;
		n_y_a.housePrice = 100;
		n_y_a.houseRent = new int[]{16, 80, 220, 600, 800};
		n_y_a.hotelRent = 1000;
		propertyList.add(n_y_a);
		
		Property k_a = new Property("red", "Kentucky avenue");
		k_a.price = 220;
		k_a.mortgage = 110;
		k_a.housePrice = 150;
		k_a.houseRent = new int[]{18, 90, 250, 700, 875};
		k_a.hotelRent = 1050;
		propertyList.add(k_a);
		
		Property in_a = new Property("red", "Indiana avenue");
		in_a.price = 220;
		in_a.mortgage = 110;
		in_a.housePrice = 150;
		in_a.houseRent = new int[]{18, 90, 250, 700, 875};
		in_a.hotelRent = 1050;
		propertyList.add(in_a);
		
		Property il_a = new Property("red", "Illinois avenue");
		il_a.price = 240;
		il_a.mortgage = 120;
		il_a.housePrice = 150;
		il_a.houseRent = new int[]{20, 100, 300, 750, 925};
		il_a.hotelRent = 1100;
		propertyList.add(il_a);
		
		Property a_a = new Property("yellow", "atlantic avenue");
		a_a.price = 260;
		a_a.mortgage = 130;
		a_a.housePrice = 150;
		a_a.houseRent = new int[]{22, 110, 330, 800, 975};
		a_a.hotelRent = 1150;
		propertyList.add(a_a);
		
		Property ve_a = new Property("yellow", "Ventor avenue");
		ve_a.price = 260;
		ve_a.mortgage = 130;
		ve_a.housePrice = 150;
		ve_a.houseRent = new int[]{22, 110, 330, 800, 975};
		ve_a.hotelRent = 1150;
		propertyList.add(ve_a);
		
		Property m_g = new Property("yellow", "Marvin gardens");
		m_g.price = 280;
		m_g.mortgage = 140;
		m_g.housePrice = 150;
		m_g.houseRent = new int[]{24, 120, 360, 850, 1025};
		m_g.hotelRent = 1200;
		propertyList.add(m_g);
		
		Property p_a = new Property("green", "Pacific avenue");
		p_a.price = 300;
		p_a.mortgage = 150;
		p_a.housePrice = 150;
		p_a.houseRent = new int[]{26, 130, 390, 900, 1100};
		p_a.hotelRent = 1275;
		propertyList.add(p_a);
		
		Property n_c_a = new Property("green", "North Carolina avenue");
		n_c_a.price = 300;
		n_c_a.mortgage = 150;
		n_c_a.housePrice = 150;
		n_c_a.houseRent = new int[]{26, 130, 390, 900, 1100};
		n_c_a.hotelRent = 1275;
		propertyList.add(n_c_a);
		
		Property pe_a = new Property("green", "Pensylvania avenue");
		pe_a.price = 320;
		pe_a.mortgage = 160;
		pe_a.housePrice = 150;
		pe_a.houseRent = new int[]{28, 150, 450, 1000, 1200};
		pe_a.hotelRent = 1400;
		propertyList.add(pe_a);
		
		Property p_p = new Property("dark blue", "Park place");
		p_p.price = 350;
		p_p.mortgage = 175;
		p_p.housePrice = 175;
		p_p.houseRent = new int[]{35, 175, 500, 1100, 1300};
		p_p.hotelRent = 1500;
		propertyList.add(p_p);
		
		Property b = new Property("dark blue", "Boardwalk");
		b.price = 400;
		b.mortgage = 200;
		b.housePrice = 175;
		b.houseRent = new int[]{50, 200, 600, 1400, 1700};
		b.hotelRent = 2000;
		propertyList.add(b);
		
		Property r_r = new Property("railroad", "Reading railroad");
		r_r.railroad = true;
		r_r.price = 200;
		r_r.mortgage = 100;
		propertyList.add(r_r);
		
		Property p_r = new Property("railroad", "pennsylvania railroad");
		p_r.railroad = true;
		p_r.price = 200;
		p_r.mortgage = 100;
		propertyList.add(p_r);
		
		Property b_r = new Property("railroad", "B. & O. railroad");
		b_r.railroad = true;
		b_r.price = 200;
		b_r.mortgage = 100;
		propertyList.add(b_r);
		
		Property s_r = new Property("railroad", "Short line");
		s_r.railroad = true;
		s_r.price = 200;
		s_r.mortgage = 100;
		propertyList.add(s_r);
		
		Property e_c = new Property("utility", "Electric company");
		e_c.utility = true;
		e_c.price = 150;
		e_c.mortgage = 75;
		propertyList.add(e_c);
		
		Property w_w = new Property("utility", "Water works");
		w_w.utility = true;
		w_w.price = 150;
		w_w.mortgage = 75;
		propertyList.add(w_w);
	}
}