package com.keeboi.dfs.callback;

import com.keeboi.dfs.model.Node;
import com.keeboi.dfs.model.NodeNotFoundException;

public interface TreeCallback {
	
	abstract void onNodeFound(Node node);
	abstract void onNodeNotFound() throws NodeNotFoundException;
	
}
