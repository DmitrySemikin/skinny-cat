package xyz.dsemikin.skinnycat.guiswing;

import xyz.dsemikin.skinnycat.guiswing.gui.SkinnyCatMainWindow;
import xyz.dsemikin.skinnycat.guiswing.jpa.EntityManagerProviderHibernate;
import xyz.dsemikin.skinnycat.jpa.dao.FoodstuffDao;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDtoJpa;

import javax.swing.SwingUtilities;
import java.util.List;

public class SkinnyCatGuiSwing {
    public static void main(String[] argv) {
        EntityManagerProviderHibernate p = new EntityManagerProviderHibernate();
        FoodstuffDao dao = new FoodstuffDao(p);
        List<FoodstuffDtoJpa> all = dao.all();
        p.close();

        SwingUtilities.invokeLater(SkinnyCatMainWindow::new);
    }
}
