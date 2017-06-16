package axoloti.parameterviews;

import axoloti.objectviews.IAxoObjectInstanceView;
import axoloti.parameters.ParameterInstanceController;
import axoloti.parameters.ParameterInstanceInt32VRadio;
import axoloti.parameters.ParameterInt32VRadio;
import components.AssignMidiCCMenuItems;
import components.control.VRadioComponent;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

class ParameterInstanceViewInt32VRadio extends ParameterInstanceViewInt32 {

    public ParameterInstanceViewInt32VRadio(ParameterInstanceController controller, IAxoObjectInstanceView axoObjectInstanceView) {
        super(controller, axoObjectInstanceView);
    }

    @Override
    public void updateV() {
        ctrl.setValue(getModel().getValue().getInt());
    }

    @Override
    public VRadioComponent CreateControl() {
        return new VRadioComponent(0, ((ParameterInt32VRadio) getModel().getModel()).MaxValue.getInt());
    }

    @Override
    public VRadioComponent getControlComponent() {
        return (VRadioComponent) ctrl;
    }

    @Override
    public void populatePopup(JPopupMenu m) {
        super.populatePopup(m);
        JMenu m1 = new JMenu("Midi CC");
        // AssignMidiCCMenuItems, does stuff in ctor
        AssignMidiCCMenuItems assignMidiCCMenuItems = new AssignMidiCCMenuItems(this, m1);
        m.add(m1);
    }
}
