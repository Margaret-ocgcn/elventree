import com.fhj.elventree.registery.Dict;
import com.fhj.elventree.xml.Logic;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/trans")
public class TransController {
    private static Log log = LogFactory.getLog("TransInfo");
    @Autowired
    private Map errorCode;
    @Autowired
    private Dict dict;
    @Autowired
    private Logic logic;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "getback/{taskId}")
    public String getAsyncRes(@PathVariable String taskId) {
        return taskId;
    }



    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public void setErrorCode(Map errorCode) {
        this.errorCode = errorCode;
    }

    public Map getErrorCode() {
        return errorCode;
    }

    public void setDict(Dict dict) {
        this.dict = dict;
    }

    public Dict getDict() {
        return dict;
    }
}
