package playacem.allrondism.tileentity;

/**
 * Allrondism
 * 
 * ICoreExtension
 * 
 * this interface is implemented my every TileEntity, which belong to the core
 * 
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface ICoreExtension {


    /** save the given core somewhere */
    public void setCore(TileEntityMultiFurnaceCore core);
    
    /** return the saved core here */
    public TileEntityMultiFurnaceCore getCore();
    
}
